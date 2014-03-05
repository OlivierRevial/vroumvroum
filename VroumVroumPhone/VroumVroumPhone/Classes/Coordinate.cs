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
        public double longitude { get; set; }
        public double latitude { get; set; }

        public Coordinate() {
            longitude = 0;
            latitude = 0;
        }
        public Coordinate(double _longitude, double _latitude)
        {
            this.longitude = _longitude;
            this.latitude = _latitude;
        }
        public Coordinate(int _id, double _longitude, double _latitude)
        {
            this.id = _id;
            this.longitude = _longitude;
            this.latitude = _latitude;
        }

    }
}
