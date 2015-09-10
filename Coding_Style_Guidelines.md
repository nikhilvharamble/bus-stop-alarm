We plan on using the Android Code Style Rules as a model for our coding guidelines found from the following link:
http://source.android.com/submit-patches/code-style-guide
We have decided to use this guideline to be consistent with the style used for other android applications.

Consistency of the coding style between group members will be enforced by code reviews. Beginning each new piece of code that is uploaded to the svn we will add a review request to the issues page of our wiki. The review request will state what code was uploaded and what new parts need to be reviewed. We will track the consistency by having a reviewer check the portion of code that was just checked in. We will create a rotational schedule of who's turn it is to review the new code. By using a rotational pattern of reviewers it guarantees that different members check the coding style for new documents submitted.

We will require that every change to the repository has to have clear and detail comments about what are changed, the scope of the change, date, who is responsible, etc so that the code reviews won't be redundant. During the code reviews we recommend that our members use PMD to review the code, but it is up to them whether on not they use it, otherwise they must examine the code by hand.

Once the code review is completed the reviewer signs off on the review request issue with documentation of what needed changes there are. The original coder must then review the reviewers changes, modify the code and resubmit.