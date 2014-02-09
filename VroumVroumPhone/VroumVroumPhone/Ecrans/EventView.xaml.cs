using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace VroumVroumPhone.Ecrans
{
    public partial class EventView : PhoneApplicationPage
    {
        public EventView()
        {
            InitializeComponent();
        }
        protected override void OnNavigatedTo(System.Windows.Navigation.NavigationEventArgs e)
        {
            base.OnNavigatedTo(e);
            string eventId = this.NavigationContext.QueryString["parameter"];
            
            //this.DataContext = new EventViewModel();

        }
    }
}