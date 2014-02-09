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
            buildEventsListedBar();
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
            IsLoading.Visibility = Visibility.Collapsed;
        }
        private void buildEventsListedBar()
        {
            //Affichage de la barre
            ApplicationBar = new ApplicationBar();
            ApplicationBar.Opacity = 1.0;
            ApplicationBar.Mode = ApplicationBarMode.Minimized;
            ApplicationBar.IsVisible = true;
            ApplicationBar.IsMenuEnabled = true;

            //Bouton Add
            ApplicationBarIconButton btnAdd = new ApplicationBarIconButton();
            btnAdd.IconUri = new Uri("/Assets/Icons/Dark/add.png", UriKind.Relative);
            btnAdd.Text = "Nouveau";
            btnAdd.Click += new EventHandler(btnAdd_Click);
            ApplicationBar.Buttons.Add(btnAdd);

            //Bouton Search
            ApplicationBarIconButton btnSearch = new ApplicationBarIconButton();
            btnSearch.IconUri = new Uri("/Assets/Icons/Dark/feature.search.png", UriKind.Relative);
            btnSearch.Text = "Rechercher";
            btnSearch.Click += new EventHandler(btnSearch_Click);
            ApplicationBar.Buttons.Add(btnSearch);
        }
        private void btnAdd_Click(Object sender, EventArgs e)
        {
            NavigationService.Navigate(new Uri("/Ecrans/AddEventView.xaml", UriKind.Relative));
        }
        private void btnSearch_Click(Object sender, EventArgs e)
        {
            // pop up ?
        }
    }
}