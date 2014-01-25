using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace mesClasses
{
    public class Country
    {
        public string name{get;set;}
        public int id { get; set; }
        public Country(string _name)
        {
            this.name = _name;
        }
        public Country(int _id, string _name)
        {
            this.id = _id;
            this.name = _name;
        }
    }
}
