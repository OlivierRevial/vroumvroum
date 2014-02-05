using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using VroumVroumPhone.Model;

namespace VroumVroumPhone.ViewModels
{
    public class EventsViewModel : INotifyPropertyChanged
    {
        public ObservableCollection<EventViewModel> Events { get; set; }
        public event PropertyChangedEventHandler PropertyChanged = delegate { };

        public EventsViewModel()
        {
            Events = new ObservableCollection<EventViewModel>();

            //string url = "http://82.236.45.188/AgendaWS/events";
            string url = "http://82.236.45.188/VroumVroum/events?page=1&resultsPerPage=40";

            var task = new HttpGetTask<EventsList>(url, this.OnPostExecute);
            task.OnPreExecute = this.OnPreExecute;
            task.OnError = this.OnError;

            task.Execute();
        }
        private void OnPreExecute()
        {
            this.IsLoading = true;
        }

        private void OnPostExecute(EventsList responseObject)
        {
            this.OnEventsDownloaded(responseObject);
            this.IsLoading = false;
        }

        private void OnError(string message)
        {
            this.IsLoading = false;
        }
        private bool _isLoading;

        public bool IsLoading
        {
            get { return _isLoading; }
            set
            {
                _isLoading = value;
                RaisePropertyChanged("IsLoading");
            }
        }
        private void OnEventsDownloaded(EventsList eventsList)
        {
            var eventModels = eventsList.Events
                .Select(c =>
                        new EventViewModel
                        {
                            Id = c.Id,
                            Name = c.Name,
                            Description = c.Description
                        })
                .ToList();

            eventModels.ForEach(this.Events.Add);
        }
        public void RaisePropertyChanged(string propertyName)
        {
            PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
