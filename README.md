### Description

This project simulates the behavior of input fields showcased in
the Android Contacts Application.

![Gif](view.gif?raw=true)

### Scope
In this project you can see the following topics:

- Create Compound Views 
- Dynamically create and remove views from code
- Use attribute declarable-styles to be able to declare properties
via XML within your Custom Views

### Details

In this project two Custom Views are created in order to get the desired
behaviour. The first one is ```CustomField``` which is a CompoundView
that contains an EditText and a ImageButton to work
as a clear/erase button.

How the ```CustomField``` is going to behave, set it's input type,
and error message, is determined by the ```CustomFieldGroup``` which
is at it's core a ```LinearLayout``` that also contains an Image for
the input reference and a button to add more ```CustomField``` views.

The ```CustomFieldGroup``` view also manages the interaction
between adding/removing fields, set it's properties and returning
the values from each input.
