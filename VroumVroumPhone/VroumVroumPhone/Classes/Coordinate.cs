using System;
using System.Collections.Generic;
using System.Device.Location;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VroumVroumPhone.Classes
{
    public class Coordinate
    {
        public int id { get; set; }
        public decimal longitude { get; set; }
        public decimal latitude { get; set; }
        public Coordinate(decimal _longitude, decimal _latitude)
        {
            this.longitude = _longitude;
            this.latitude = _latitude;
        }
        public Coordinate(int _id, decimal _longitude, decimal _latitude)
        {
            this.id = _id;
            this.longitude = _longitude;
            this.latitude = _latitude;
        }

    }
}
