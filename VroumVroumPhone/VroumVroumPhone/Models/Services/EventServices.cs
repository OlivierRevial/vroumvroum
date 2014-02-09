using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;
using VroumVroumPhone.Classes;

namespace VroumVroumPhone.Models.Services
{
    public class EventServices
    {
        private string url = "http://82.236.45.188/AgendaWS/";
        private HttpClient client;
        private Event theEvent;
        private List<Event> listEvents;

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
        public async Task<List<Event>> getEvents()
        {
            HttpResponseMessage response = await client.GetAsync("events");
            if (response.IsSuccessStatusCode)
            {
                listEvents = await response.Content.ReadAsAsync<List<Event>>();
            }
            return listEvents;
        }
        public async Task addEvent(Event newEvent)
        {
            HttpResponseMessage response = await client.PostAsJsonAsync("events", newEvent);
        }
        public async Task updateEvent(Event theEvent)
        {
            HttpResponseMessage response = await client.PutAsJsonAsync("events/", theEvent);
        }
        public async Task deleteEvent(Event theEvent)
        {
            HttpResponseMessage response = await client.DeleteAsync("events/" + theEvent.id);
        }

    }

}
