using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace mesClasses
{
    class Adress
    {
        public string name{get;set;}
        public int id { get; set; }
        public int cityId { get; set; }
        public int coordinateId { get; set; }
        public Adress(string _name, int _cityId, int _coordinateId)
        {
            this.name = _name;
            this.cityId = _cityId;
            this.coordinateId = _coordinateId;
        }
        public Adress(int _id, string _name, int _cityId, int _coordinateId)
        {
            this.id = _id;
            this.name = _name;
            this.cityId = _cityId;
            this.coordinateId = _coordinateId;
        }
    }
}
