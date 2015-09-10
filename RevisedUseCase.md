NOTE: The formatted version is available on http://docs.google.com/Doc?docid=0Acv9MM4P0J75ZGZnOGcybnRfMzg0ZmhxZzluaHQ&hl=en


Revised Use Case - Bus Stop Alarm

Use Case 1: Identify the destination through Map Page

Primary Actor
The person using the application

Level
Subfunction - Identifying the destination is a part of the ultimate goal of setting up an alarm for that destination.

Preconditions
The user already has Bus Stop Alarm open, and is on the Main Page.

Minimal Guarantees
User remains on Main Page, and error messages are logged for figuring out what went wrong.

Success Guarantees
Application acknowledges destination chosen by user; user is taken to the Confirmation Page with the destination selected.

Success Scenario
1. The user inputs a bus route number from the Main Page.
2. The app queries route and stop locations for given bus route from the OneBusAway server, while the user is taken to the Map Page.
3. The app draws routes and mark stop locations on Map page.
4. The user selects one of the stop locations marked by the app.

Extensions
1a. The user input format is invalid.
  1. 1. App informs user that the bus route number is invalid.
  1. 2. App remains on Main Page, and gets new bus route number from user.
2a. The given bus route number does not exist on server.
> 2a1. App informs user that an error occurred.
> 2a2. App logs the error, and user is taken back to Main Page.
2b. The OneBusAway server is unavailable.
> 2b1. App informs user that an error occurred.
> 2b2. App logs the error, and user is taken back to Main Page.