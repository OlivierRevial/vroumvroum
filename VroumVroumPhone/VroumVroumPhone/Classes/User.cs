using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VroumVroumPhone.Classes
{
    public class User
    {
        public int id { get; set; }
        public string mail { get; set; }
        public string password { get; set; }
        public string token { get; set; }
        public User(string _mail, string _password)
        {
            this.mail = _mail;
            this.password = _password;
            //Récupérer l'id
        }
        public User(int _id, string _mail, string _password)
        {
            this.id = _id;
            this.mail = _mail;
            this.password = _password;
            //Créer un token
        }
    }
}
