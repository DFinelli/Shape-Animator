Dan Finelli
Assignment 10.

All of my features work for the most part. I did not do any of the extra credit.

1. Tweening

The tweening function in the abstract motion takes in the from and to X/Y/W/H/R/G/B value of the
motion and computes its appropriate value at that tick in time. This functions properly every time
it is called in the model. The model then returns the shapes at the given frame which transfers
the list to the AnimationView which processes the images at that frame.

2. GUI / Swing

The shapes are being drawn properly according to their tweened values. The one properly I had
which is a problem overlapping from the previous assignment is the RGB colors. I think I am
converting the numbers incorrectly because my images are slightly off color. This problem is the
same from last time so I hope I will not lose points again for the same problem (which at this time
I haven't received feedback so I'm not sure how to fix).

3. Behaviour of visual view

I tested the GUI view and the shapes
appear as they should (besides color). The scrollbar has been added using JScrollPane. The shapes
are ordered by their appear time as they are saved.

4. Command line option

The new view can be called in the command line as <iv visual>.

5. Submission

There is a Jar file (named AS8) that works and a screenshot named "NightSkyScreenshot.png" which
both can found in the resources folder.

6. Other:

One thing I think I should have done differently is have two controllers. One for the SVG/txt views
and one for the new view. I was very confused about this and my code might look like spaghetti.

7. Note:
There are lots of fixes I would make, but working as alone I felt like I didn't have time to fix
small mistakes like the coloring being off. I felt limited to making sure my program works
adequately due to time constraints. I hope this is taken into consideration when grading
an individual's assignment versus a team assignment.


 
