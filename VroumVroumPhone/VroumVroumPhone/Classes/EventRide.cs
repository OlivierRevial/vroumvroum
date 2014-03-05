using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace VroumVroumPhone.Classes
{
    public class EventRide
    {
        public int id { get; set; }

        public Ride ride { get; set; }
        public int nbVotes { get; set; }
    }
}
