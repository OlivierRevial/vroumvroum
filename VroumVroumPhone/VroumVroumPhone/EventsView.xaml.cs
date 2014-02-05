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
using VroumVroumPhone.ViewModels;

namespace VroumVroumPhone
{
    public partial class EventsView : PhoneApplicationPage
    {
        public EventsView()
        {
            InitializeComponent();
            this.DataContext = new EventsViewModel();
        }
        
    }
}