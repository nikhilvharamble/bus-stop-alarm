# Use Case 2: Adjusts Alarm #

**Primary Actor:** App

**Level:** Subfunction	  //not sure

**Preconditions:** The program is on, a destination and a bus route are given, App has access to the Internet.

**Minimal Guarantee:** App retains the current alarm time. (no update)

**Success Guarantee:** App adjusts the alarm time based on the calculations.

**Main Success Scenario:**
  * 1. App uses GPS to determine current location.
  * 2. App calculates new alarm time based on several factors.
  * 3. Sets the new alarm time.
**Extensions:**
  * 1a. GPS is unable to determine current location.
    * 1a1. App checks if App has been unable to determine current location for an extended amount of time, and notifies user if this is so.
    * 1a2. App retains the current alarm time, and backs out of use case.
  * 2a. Some of the factors cannot not be determined.
    * 2a1. App retains the current alarm time, and backs out of use case.