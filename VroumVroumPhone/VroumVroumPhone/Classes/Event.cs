using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VroumVroumPhone.Classes
{
    public class Event
    {
        public int id { get; set; }
        public string name { get; set; }
        public string description { get; set; }

        public int nbParticipants { get; set; }
        //public DateTime createdAt { get; set; }
        //public DateTime updatedAt { get; set; }
        //public Adress address { get; set; }
        //public User owner { get; set; }
        //public List<User> participants { get; set; }
        //public List<User> organizers { get; set; }
        //public List<User> guests { get; set; }
        //public List<Comment> comments { get; set; }
        public List<EventRide> rides { get; set; }
        public Event()
        {
            this.name = "";
            this.description = "";
            //this.createdAt = this.updatedAt = DateTime.Now;
        }   
        public Event(string _name, string _description)
        {
            this.name = _name;
            this.description = _description;
            //this.createdAt = this.updatedAt = DateTime.Now;
        }
    }
}
