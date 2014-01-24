using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace mesClasses
{
    class Departement
    {
        public string name{get;set;}
        public int id { get; set; }
        public int regionId { get; set; }
        public Departement(string _name, int _regionId)
        {
            this.name = _name;
            this.regionId = _regionId;
        }
        public Departement(int _id, string _name, int _regionId)
        {
            this.id = _id;
            this.name = _name;
            this.regionId = _regionId;
        }
    }
}
