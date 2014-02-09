using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using VroumVroumPhone.Classes;
using VroumVroumPhone.Models.Services;
using Microsoft.Phone.Maps.Controls;

namespace VroumVroumPhone.Ecrans
{
    public partial class EventView : PhoneApplicationPage
    {
        public EventView()
        {
            InitializeComponent();
            Map MyMap = new Map();
            theEvent.Children.Add(MyMap);
        }
        protected override void OnNavigatedTo(System.Windows.Navigation.NavigationEventArgs e)
        {
            base.OnNavigatedTo(e);
            string eventId = this.NavigationContext.QueryString["parameter"];

            this.load_item(Convert.ToInt32(eventId));

        }
        private async void load_item(int id)
        {
            EventServices eventsServices = new EventServices();
            Event getEvent = await eventsServices.getEvent(id);
            pageTitle.Text = getEvent.name;
            theEvent.DataContext = getEvent;
        }
    }
}