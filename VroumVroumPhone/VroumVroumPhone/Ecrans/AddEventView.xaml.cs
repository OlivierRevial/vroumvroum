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
    public partial class AddEventView : PhoneApplicationPage
    {
        public AddEventView()
        {
            InitializeComponent();
            DateTime date = DateTime.Now;
            beginDate.Value = date;
            endDate.Value = date;
            buildEventViewAddBar();
        }
        private void buildEventViewAddBar()
        {
            ApplicationBar = new ApplicationBar();
            ApplicationBar.Mode = ApplicationBarMode.Minimized;
            ApplicationBar.Opacity = 1.0;
            ApplicationBar.IsVisible = true;
            ApplicationBar.IsMenuEnabled = true;

            //Bouton Sauvegarder
            ApplicationBarIconButton btnSave = new ApplicationBarIconButton();
            btnSave.IconUri = new Uri("/Assets/Icons/Dark/save.png", UriKind.Relative);
            btnSave.Text = "Sauvegarder";
            btnSave.Click += new EventHandler(btnSave_Click);
            ApplicationBar.Buttons.Add(btnSave);

            //Bouton Annuler
            ApplicationBarIconButton btnCancel = new ApplicationBarIconButton();
            btnCancel.IconUri = new Uri("/Assets/Icons/Dark/cancel.png", UriKind.Relative);
            btnCancel.Text = "Annuler";
            btnCancel.Click += new EventHandler(btnCancel_Click);
            ApplicationBar.Buttons.Add(btnCancel);
        }
        private void btnSave_Click(Object sender, EventArgs e)
        {
            Event newEvent = new Event(eventName.Text, eventDescription.Text);
            this.add_item(newEvent);
        }
        private void btnCancel_Click(Object sender, EventArgs e)
        {
            NavigationService.GoBack();
        }
        private async void add_item(Event theEventToAdd)
        {
            EventServices eventService = new EventServices();
            int code = await eventService.addEvent(theEventToAdd);
            if (code == 201 || code == 200)
            {
                MessageBox.Show("Création effectuée avec succès");
                EventsView.eventsCollection.Add(theEventToAdd);
                NavigationService.GoBack();
            }
            else
            {
                MessageBox.Show("Création impossible");
            }
        }
    }
}