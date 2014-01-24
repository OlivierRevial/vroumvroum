using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace mesClasses
{
    class City
    {
        public string name{get;set;}
        public int id { get; set; }
        public int departementId { get; set; }
        public City(string _name, int _departementId)
        {
            this.name = _name;
            this.departementId = _departementId;
        }
        public City(int _id, string _name, int _departementId)
        {
            this.id = _id;
            this.name = _name;
            this.departementId = _departementId;
        }
    }
}
