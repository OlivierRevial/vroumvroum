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
using System.Device.Location;
using Windows.Devices.Geolocation;
using System.Windows.Shapes;
using System.Windows.Media;
using Microsoft.Phone.Maps.Services;
using System.Diagnostics;

namespace VroumVroumPhone.Ecrans
{
    public partial class EventView : PhoneApplicationPage
    {
        Map MyMap { get; set; }
        RouteQuery RideQuery { get; set; }
        Color RouteColor { get; set; }

        public EventView()
        {
            InitializeComponent();
            MyMap = new Map();
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
            //pageTitle.Text = getEvent.name;
            theEvent.DataContext = getEvent;

            centerMap();
            for (int i = 0; i < getEvent.rides.Count; i++) {
                IEnumerable<GeoCoordinate> ride = convertToGeoRide(getEvent.rides.ElementAt(i).ride.ridesAddresses);
                drawRide(ride, getRideColor(i));
                drawRidePinPoints(ride);
            }
        }

        private async void centerMap() {
            // Get my current location.
            Geolocator myGeolocator = new Geolocator();
            Geoposition myGeoposition = await myGeolocator.GetGeopositionAsync();
            Geocoordinate myGeocoordinate = myGeoposition.Coordinate;
            GeoCoordinate myGeoCoordinate = CoordinateConverter.ConvertGeocoordinate(myGeocoordinate);
            this.map1.Center = myGeoCoordinate;

            // Add point showing current user position
            drawPinPoint(myGeoCoordinate, Colors.Blue);
        }

        private Color getRideColor(int position) {
            switch (position) {
                case 1: return Colors.Brown;
                case 2: return Colors.Blue;
                case 3: return Colors.Green;
                case 4: return Colors.Yellow;
                case 5: return Colors.Purple;
                default: return Colors.Red;
            }
        }

        private void drawRidePinPoints(IEnumerable<GeoCoordinate> ride) {
            for (int i = 0; i < ride.Count(); i++)
            {
                Color pinColor;
                if (i == 0)
                {
                    pinColor = Colors.Green;
                }
                else if (i == ride.Count() - 1)
                {
                    pinColor = Colors.Red;
                }
                else
                {
                    pinColor = Colors.Orange;
                }
                drawPinPoint(ride.ElementAt(i), pinColor);
            }
        }

        private void drawPinPoint(GeoCoordinate coordinate, Color color) {
            // Create a small circle to mark the current location.
            Ellipse myCircle = new Ellipse();
            myCircle.Fill = new SolidColorBrush(color);
            myCircle.Height = 15;
            myCircle.Width = 15;
            myCircle.Opacity = 50;

            // Create a MapOverlay to contain the circle.
            MapOverlay myLocationOverlay = new MapOverlay();
            myLocationOverlay.Content = myCircle;
            myLocationOverlay.PositionOrigin = new Point(0.5, 0.5);
            myLocationOverlay.GeoCoordinate = coordinate;

            // Create a MapLayer to contain the MapOverlay.
            MapLayer myLocationLayer = new MapLayer();
            myLocationLayer.Add(myLocationOverlay);

            // Add the MapLayer to the Map.
            this.map1.Layers.Add(myLocationLayer);
        }

        private IEnumerable<GeoCoordinate> convertToGeoRide(List<RideAddress> addresses) {
            List<GeoCoordinate> coords = new List<GeoCoordinate>();
            foreach (RideAddress rideAd in addresses) {
                coords.Add(new GeoCoordinate(rideAd.address.coordinates.latitude, rideAd.address.coordinates.longitude));
            }
            return coords;
        }
        
        private void drawRide(IEnumerable<GeoCoordinate> ride, Color color) {
            RideQuery = new RouteQuery();

            RouteColor = color;
            RideQuery.Waypoints = ride;
            RideQuery.TravelMode = TravelMode.Driving;
            RideQuery.QueryCompleted += RideQuery_QueryCompleted;
            RideQuery.QueryAsync();
        }
        void RideQuery_QueryCompleted(object sender, QueryCompletedEventArgs<Route> e)
        {
            if (e.Error == null)
            {
                Route MyRoute = e.Result;
                MapRoute MyMapRoute = new MapRoute(MyRoute);
                MyMapRoute.Color = RouteColor;
                this.map1.AddRoute(MyMapRoute);
                RideQuery.Dispose();
            }
        }

        private GeoCoordinate convertToGeoCoordinates(Coordinate coord) {
            return new GeoCoordinate((double) coord.latitude, (double) coord.longitude);
        }

        private IEnumerable<GeoCoordinate> getRide()
        {
            List<GeoCoordinate> ride = new List<GeoCoordinate>();
            ride.Add(new GeoCoordinate(44.889645, -0.615682));
            ride.Add(new GeoCoordinate(44.803354, -0.660658));
            ride.Add(new GeoCoordinate(44.830542, -0.502239));
            ride.Add(new GeoCoordinate(45.628533, -1.020046));

            /*
            ride.Add(new GeoCoordinate(44.842959, -0.572877));
            ride.Add(new GeoCoordinate(45.628533, -1.020046));
            */

            return ride;
        }

        public static class CoordinateConverter
        {
            public static GeoCoordinate ConvertGeocoordinate(Geocoordinate geocoordinate)
            {
                return new GeoCoordinate
                    (
                    geocoordinate.Latitude,
                    geocoordinate.Longitude,
                    geocoordinate.Altitude ?? Double.NaN,
                    geocoordinate.Accuracy,
                    geocoordinate.AltitudeAccuracy ?? Double.NaN,
                    geocoordinate.Speed ?? Double.NaN,
                    geocoordinate.Heading ?? Double.NaN
                    );
            }
        }
    }
}