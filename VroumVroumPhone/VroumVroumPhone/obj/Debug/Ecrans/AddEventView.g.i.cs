﻿#pragma checksum "E:\Projects_EE\VroumVroumAPI\vroumvroum\VroumVroumPhone\VroumVroumPhone\Ecrans\AddEventView.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "C538A08E6CFF6EF1649FC78DF33C1449"
//------------------------------------------------------------------------------
// <auto-generated>
//     Ce code a été généré par un outil.
//     Version du runtime :4.0.30319.34011
//
//     Les modifications apportées à ce fichier peuvent provoquer un comportement incorrect et seront perdues si
//     le code est régénéré.
// </auto-generated>
//------------------------------------------------------------------------------

using Microsoft.Phone.Controls;
using System;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Automation.Peers;
using System.Windows.Automation.Provider;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Interop;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;
using System.Windows.Resources;
using System.Windows.Shapes;
using System.Windows.Threading;


namespace VroumVroumPhone.Ecrans {
    
    
    public partial class AddEventView : Microsoft.Phone.Controls.PhoneApplicationPage {
        
        internal System.Windows.Controls.Grid LayoutRoot;
        
        internal System.Windows.Controls.Grid ContentPanel;
        
        internal System.Windows.Controls.TextBox eventName;
        
        internal System.Windows.Controls.TextBox eventDescription;
        
        internal Microsoft.Phone.Controls.DatePicker beginDate;
        
        internal Microsoft.Phone.Controls.TimePicker beginDate_time;
        
        internal Microsoft.Phone.Controls.DatePicker endDate;
        
        internal Microsoft.Phone.Controls.TimePicker endDate_time;
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Windows.Application.LoadComponent(this, new System.Uri("/VroumVroumPhone;component/Ecrans/AddEventView.xaml", System.UriKind.Relative));
            this.LayoutRoot = ((System.Windows.Controls.Grid)(this.FindName("LayoutRoot")));
            this.ContentPanel = ((System.Windows.Controls.Grid)(this.FindName("ContentPanel")));
            this.eventName = ((System.Windows.Controls.TextBox)(this.FindName("eventName")));
            this.eventDescription = ((System.Windows.Controls.TextBox)(this.FindName("eventDescription")));
            this.beginDate = ((Microsoft.Phone.Controls.DatePicker)(this.FindName("beginDate")));
            this.beginDate_time = ((Microsoft.Phone.Controls.TimePicker)(this.FindName("beginDate_time")));
            this.endDate = ((Microsoft.Phone.Controls.DatePicker)(this.FindName("endDate")));
            this.endDate_time = ((Microsoft.Phone.Controls.TimePicker)(this.FindName("endDate_time")));
        }
    }
}

