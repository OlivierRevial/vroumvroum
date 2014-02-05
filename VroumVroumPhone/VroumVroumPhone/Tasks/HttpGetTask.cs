using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Runtime.Serialization.Json;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace VroumVroumPhone.Model
{
    public class HttpGetTask<T>
    {
        public HttpGetTask(string url, Action<T> onPostExecute)
        {
            this.Url = url;
            this.OnPostExecute = onPostExecute;
        }

        public void Execute()
        {
            if (this.OnPreExecute != null)
            {
                this.OnPreExecute();
            }

            // create the http request
            HttpWebRequest httpWebRequest = WebRequest.CreateHttp(this.Url);
            httpWebRequest.Method = "GET";
            httpWebRequest.Accept = "application/json";

            // get the response asynchronously
            httpWebRequest.BeginGetResponse(OnGetResponseCompleted, httpWebRequest);
        }

        private void OnGetResponseCompleted(IAsyncResult ar)
        {
            var httpWebRequest = (HttpWebRequest)ar.AsyncState;

            // get the response
            HttpWebResponse response;
            try
            {
                response = (HttpWebResponse)httpWebRequest.EndGetResponse(ar);
            }
            catch (WebException)
            {
                this.InvokeOnErrorHandler("Unable to connect to the web page.");
                return;
            }
            catch (Exception e)
            {
                this.InvokeOnErrorHandler(e.Message);
                return;
            }

            if (response.StatusCode != HttpStatusCode.OK)
            {
                this.InvokeOnErrorHandler((int)response.StatusCode + " " + response.StatusDescription);
                return;
            }

            // response stream
            var stream = response.GetResponseStream();

            // deserialize json
            var jsonSerializer = new DataContractJsonSerializer(typeof(T));
            var responseObject = (T)jsonSerializer.ReadObject(stream);

            // call the virtual method
            this.InvokeInUiThread(() => this.OnPostExecute(responseObject));
        }

        private void InvokeOnErrorHandler(string message)
        {
            if (this.OnError != null)
            {
                this.InvokeInUiThread(() => this.OnError(message));
            }
        }

        private void InvokeInUiThread(Action action)
        {
            Deployment.Current.Dispatcher.BeginInvoke(action);
        }

        public string Url { get; private set; }

        public Action<T> OnPostExecute { get; private set; }

        public Action OnPreExecute { get; set; }

        public Action<string> OnError { get; set; }
    }
}
