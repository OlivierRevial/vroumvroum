using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Formatting;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;
using VroumVroumPhone.Classes;

namespace VroumVroumPhone.Models.Services
{
    public class EventServices
    {
        private string url = "http://82.236.45.188/VroumVroum/";
        private HttpClient client;
        private Event theEvent;
        private List<Event> eventsList;

        public EventServices()
        {
            if (client == null)
            {
                client = new HttpClient();
            }
            client.BaseAddress = new Uri(url);
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }
        public async Task<Event> getEvent(int id)
        {
            HttpResponseMessage response = await client.GetAsync("events/" + id);
            if (response.IsSuccessStatusCode)
            {
                theEvent = await response.Content.ReadAsAsync<Event>();
            }
            return theEvent;
        }
        public async Task<List<Event>> getEvents(int page = 1, int nbResultsPerPage = 40)
        {
            HttpResponseMessage response = await client.GetAsync("events?page=" + page + "&resultsPerPage=" + nbResultsPerPage);
            if (response.IsSuccessStatusCode)
            {
                eventsList = await response.Content.ReadAsAsync<List<Event>>();
            }
            return eventsList;
        }
        public async Task<int> addEvent(Event newEvent)
        {
            HttpResponseMessage response = await client.PostAsJsonAsync("events?userToken=vr94H09MQB2MzK55RG", newEvent);
            return (int)response.StatusCode;
        }
        public async Task<int> updateEvent(Event theEvent)
        {
            HttpResponseMessage response = await client.PutAsJsonAsync("events?userToken=vr94H09MQB2MzK55RG", theEvent);
            return (int)response.StatusCode;
        }
        public async Task<int> deleteEvent(int id)
        {
            HttpResponseMessage response = await client.DeleteAsync("events?userToken=vr94H09MQB2MzK55RG" + id);
            return (int)response.StatusCode;
        }

    }

}
