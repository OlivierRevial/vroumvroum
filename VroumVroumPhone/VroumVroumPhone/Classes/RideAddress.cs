using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VroumVroumPhone.Classes
{
    public class RideAddress
    {
        public int id { get; set; }
        public Address address { get; set; }

        public int orderInRide { get; set; }
    }
}
