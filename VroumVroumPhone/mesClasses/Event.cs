using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace mesClasses
{
    public class Event
    {
        public int id { get; set; }
        public string name { get; set; }
        public string description { get; set; }
        public DateTime createdAt { get; set; }
        public DateTime updatedAt { get; set; }
        public Adress adress { get; set; }
        public User owner { get; set; }
        public List<User> participants { get; set; }
        public List<User> organizers { get; set; }
        public List<User> guests { get; set; }
        public List<Comment> comments { get; set; }
        public Event(string _name, string _description, User _owner)
        {
            this.name = _name;
            this.description = _description;
            this.owner = _owner;
        }
        public Event(string _name, string _description, User _owner, Adress _adress)
        {
            this.name = _name;
            this.description = _description;
            this.owner = _owner;
            this.adress = _adress;
        }
        public Event(string _name, string _description, User _owner, Adress _adress, List<User> _participants)
        {
            this.name = _name;
            this.description = _description;
            this.owner = _owner;
            this.adress = _adress;
            this.participants = _participants;
        }
        public Event(string _name, string _description, User _owner, Adress _adress, List<User> _participants, List<User> _organizers)
        {
            this.name = _name;
            this.description = _description;
            this.owner = _owner;
            this.adress = _adress;
            this.participants = _participants;
            this.organizers = _organizers;
        }
    }
}
