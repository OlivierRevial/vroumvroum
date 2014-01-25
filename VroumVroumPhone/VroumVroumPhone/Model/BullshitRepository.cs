using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using mesClasses;

namespace VroumVroumPhone.Model
{
    class BullshitRepository
    {
        private List<mesClasses.Event> allEvents;

        public BullshitRepository()
        {
            if (null == allEvents)
            {
                allEvents = new List<mesClasses.Event>();
                initEvents();
            }
        }
        private void initEvents()
        {
            User owner = new User("samuel.verron@ingesup.com","12345sam");
            allEvents.Add(new mesClasses.Event("Event 1", "description", owner));
            allEvents.Add(new mesClasses.Event("Event 2", "description", owner));
            allEvents.Add(new mesClasses.Event("Event 3", "description", owner));
            allEvents.Add(new mesClasses.Event("Event 4", "description", owner));
            allEvents.Add(new mesClasses.Event("Event 5", "description", owner));
            allEvents.Add(new mesClasses.Event("Event 6", "description", owner));
            allEvents.Add(new mesClasses.Event("Event 7", "description", owner));
            allEvents.Add(new mesClasses.Event("Event 8", "description", owner));
            allEvents.Add(new mesClasses.Event("Event 9", "description", owner));
            allEvents.Add(new mesClasses.Event("Event 10", "description", owner));
         
        }
        public List<mesClasses.Event> getAllEvents()
        {
            return allEvents;
        }
    }
}
