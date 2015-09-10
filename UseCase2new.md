# Use Case 2: Setting Alarm #

**Primary Actor:** User

**Level:** User Level

**Preconditions:** The program is on, a destination and a bus route are given.

**Minimal Guarantee:** App shows remaining time and distance to destination.

**Success Guarantee:** Alarm is set.

**Main Success Scenario:**
  * 1. User chooses a ringtone/vibration.
  * 2. App shows the remaining time and distance to destination.
  * 3. User confirms the alarm setting.
  * 4. User saves the setting in the list of favorites.
  * 5. User starts the alarm.

**Extensions:**
  * 1a. User does not choose a ringtone/vibration.
    * 1a1. App uses the default ringtone/vibration.

  * 1b. User chooses some ringtone/vibration, but phone does not support them.
    * 1b1. App notifies user the problem.
    * 1b2. App sets unsupported features off.

  * 3a. User disagrees with the setting.
    * 3a1. User backs out of this use case.

  * 4a. The setting cannot be saved.
    * 4a1. App notifies user of failure.

  * 5a. The alarm cannot be started.
    * 5a1. App notifies user of failure.
    * 5a2. User backs out of use case.