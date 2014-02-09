using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using System.Collections.ObjectModel;

namespace VroumVroumPhone
{
    public partial class EventsView : PhoneApplicationPage
    {
        public EventsView()
        {
            InitializeComponent();
            //this.DataContext = new EventsViewModel();
        }

        private void StackPanel_Tap(object sender, System.Windows.Input.GestureEventArgs e)
        {
            int id = (int)(sender as StackPanel).Tag;
            try
            {
                NavigationService.Navigate(new Uri(String.Format("/EventView.xaml?parameter={0}", id), UriKind.Relative));
            }
            catch (Exception)
            { }    
        }
        
    }
}