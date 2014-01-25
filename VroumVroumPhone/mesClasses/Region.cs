using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace mesClasses
{
    public class Region
    {
        public string name{get;set;}
        public int id { get; set; }
        public int countryId { get; set; }
        public Region(string _name, int _countryId)
        {
            this.name = _name;
            this.countryId = _countryId;
        }
        public Region(int _id, string _name, int _countryId)
        {
            this.id = _id;
            this.name = _name;
            this.countryId = _countryId;
        }
    }
}
