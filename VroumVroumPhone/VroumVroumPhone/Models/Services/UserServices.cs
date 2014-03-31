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
    public class UserServices
    {
        private string url = "http://82.236.45.188/VroumVroum/";
        private HttpClient client;
        private User theUser;
        private List<User> usersList;

        public UserServices()
        {
            if (client == null)
            {
                client = new HttpClient();
            }
            client.BaseAddress = new Uri(url);
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }
        public async Task<User> getUser(int id)
        {
            HttpResponseMessage response = await client.GetAsync("users/" + id);
            if (response.IsSuccessStatusCode)
            {
                theUser = await response.Content.ReadAsAsync<User>();
            }
            return theUser;
        }
        public async Task<List<User>> getUsers(int page = 1)
        {
            HttpResponseMessage response = await client.GetAsync("users?page=" + page);
            if (response.IsSuccessStatusCode)
            {
                usersList = await response.Content.ReadAsAsync<List<User>>();
            }
            return usersList;
        }
        public async Task<int> addUser(User newUser)
        {
            HttpResponseMessage response = await client.PostAsJsonAsync("users?userToken=vr94H09MQB2MzK55RG", newUser);
            return (int)response.StatusCode;
        }
        public async Task<int> updateUser(User theUser)
        {
            HttpResponseMessage response = await client.PutAsJsonAsync("users?userToken=vr94H09MQB2MzK55RG", theUser);
            return (int)response.StatusCode;
        }
        public async Task<int> deleteUser(int id)
        {
            HttpResponseMessage response = await client.DeleteAsync("users?userToken=vr94H09MQB2MzK55RG" + id);
            return (int)response.StatusCode;
        }

    }
}
