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

namespace VroumVroumPhone.Ecrans
{
    public partial class EventsView : PhoneApplicationPage
    {
        private List<Event> lesEvents;
        public EventsView()
        {
            InitializeComponent();
            this.load_items();
            eventsList.ItemsSource = lesEvents;
        }
        private void StackPanel_Tap(object sender, System.Windows.Input.GestureEventArgs e)
        {
            int id = (int)(sender as StackPanel).Tag;
            try
            {
                NavigationService.Navigate(new Uri(String.Format("/Ecrans/EventView.xaml?parameter={0}", id), UriKind.Relative));
            }
            catch (Exception)
            { }
        }
        private async void load_items()
        {
            EventServices eventsServices = new EventServices();
            //Event theEvent = await eventsServices.getEvent(1);
            lesEvents = await eventsServices.getEvents();
            eventsList.ItemsSource = lesEvents;
        }
    }
}