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
using System.Collections.ObjectModel;

namespace VroumVroumPhone.Ecrans
{
    public partial class EventsView : PhoneApplicationPage
    {
        public static ObservableCollection<Event> eventsCollection { get; set; }

        private int page = 1;
        public EventsView()
        {
            eventsCollection = new ObservableCollection<Event>();
            InitializeComponent();
            buildEventsListedBar();
            this.load_items();
            moreEvents.Visibility = Visibility.Collapsed;
        }
        private void StackPanel_Tap(object sender, System.Windows.Input.GestureEventArgs e)
        {
            int id = (int)(sender as StackPanel).Tag;
            NavigationService.Navigate(new Uri(String.Format("/Ecrans/EventView.xaml?parameter={0}", id), UriKind.Relative));
        }
        private async void load_items()
        {
            EventServices eventsServices = new EventServices();

            List<Event> tmpResults = await eventsServices.getEvents(page, 20);

            if (eventsCollection.Count > 0)
            {
                if (null != tmpResults)
                {
                    foreach (Event grp in tmpResults)
                    {
                        eventsCollection.Add(grp);
                    }
                    moreEvents.Visibility = Visibility.Visible;
                }
            }
            else
            {
               if(null != tmpResults){
                   foreach (Event grp in tmpResults)
                   {
                       eventsCollection.Add(grp);
                   }
               }
                eventsList.ItemsSource = eventsCollection;
                moreEvents.Visibility = Visibility.Visible;
            }
            page = page + 1;
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

        private void moreEvents_Click(object sender, RoutedEventArgs e)
        {
            moreEvents.Visibility = Visibility.Collapsed;
            this.load_items();
        }

        private void StackPanel_Hold(object sender, System.Windows.Input.GestureEventArgs e)
        {
            MessageBoxResult result = MessageBox.Show("Voulez-vous supprimer cette sortie ?", "Suppression", MessageBoxButton.OKCancel);

            if (result == MessageBoxResult.OK)
            {
                int id = (int)(sender as StackPanel).Tag;
                deleteItem(id);
            }
        }
        private async void deleteItem(int id)
        {
            EventServices eventsServices = new EventServices();
            int codeHttp = await eventsServices.deleteEvent(id);
            if (codeHttp == 200 || codeHttp == 201)
            {
                MessageBox.Show("Sortie supprimée avec succès !");
            }
            else
            {
                MessageBox.Show("Impossible de supprimer la sortie !");
            }
        }
        
    }
}