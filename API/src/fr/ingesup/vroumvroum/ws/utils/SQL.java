package fr.ingesup.vroumvroum.ws.utils;

public interface SQL {
		
	public interface Event {
		public interface TABLE {
			public static final String NAME = "event";
		}
		
		public interface COLUMN {
			public static final String _ID = "id";
			public static final String NAME = "name";
			public static final String DESCRIPTION = "description";
			public static final String PHONE_NUMBER = "phone_number";
			public static final String NUMBER_PARTICIPANTS = "number_participants";
			public static final String DATE_START = "date_start";
			public static final String DATE_END = "date_end";
			public static final String PLACE_START = "place_start";
			public static final String CREATED_AT = "created_at";
			public static final String UPDATED_AT = "updated_at";
			public static final String OWNER = "owner";
		}
	}
	
	public interface Invitation {
		public interface TABLE {
			public static final String NAME = "invitation";
		}
		
		public interface COLUMN {
			public static final String _ID = "id";
			public static final String HOST_FACEBOOK_ID = "host_facebook_id";
			public static final String GUEST_FACEBOOK_ID = "guest_facebook_id";
		}
	}
	
	public interface City {
		public interface TABLE {
			public static final String NAME = "city";
		}
		
		public interface COLUMN {
			public static final String INSEE_CODE = "insee_code";
			public static final String POSTAL_CODE = "postal_code";
			public static final String NAME = "name";
			public static final String DEPARTMENT = "department_id";
			public static final String COUNTRY = "country_id";
		}
	}
	
	public interface Department {
		public interface TABLE {
			public static final String NAME = "department";
		}
		
		public interface COLUMN {
			public static final String _ID = "id";
			public static final String NAME = "name";
		}
	}
	
	public interface Country {
		public interface TABLE {
			public static final String NAME = "country";
		}
		
		public interface COLUMN {
			public static final String _ID = "id";
			public static final String NAME_FR = "name_fr";
			public static final String NAME_EN = "name_en";
			public static final String CODE_ALPHA_1 = "code_alpha_1";
			public static final String CODE_ALPHA_2 = "code_alpha_2";
			public static final String CODE_ALPHA_3 = "code_alpha_3";
		}
	}
	
	public interface Address {
		public interface TABLE {
			public static final String NAME = "address";
		}
		
		public interface COLUMN {
			public static final String _ID = "id";
			public static final String ADDRESS = "line_principal";
			public static final String LINE_COMPLEMENT = "line_complement";
			public static final String POSTAL_CODE = "postal_code";
			public static final String CITY = "city";
			public static final String COORDINATES = "location_id";
		}
	}
	
	public interface User {
		public interface TABLE {
			public static final String NAME = "user";
		}
		
		public interface COLUMN {
			public static final String _ID = "id";
			public static final String FACEBOOK_ID = "facebook_id";
			public static final String FIRST_NAME = "first_name";
			public static final String LAST_NAME = "last_name";
			public static final String PHONE_NUMBER = "phone_number";
			public static final String EMAIL = "email";
			public static final String BIRTHDATE = "birthdate";
			public static final String PASSWORD = "password";
			public static final String ADDRESS = "address_id";
			public static final String USER = "user";
		}
	}
	
	public interface Coordinates {
		public interface TABLE {
			public static final String NAME = "coordinates";
		}
		
		public interface COLUMN {
			public static final String _ID = "id";
			public static final String LATITUDE = "latitude";
			public static final String LONGITUDE = "longitude";
		}
	}	
}
