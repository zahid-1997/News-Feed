# News-Feed

Requirements:
Users have the following capabilities (command to be used in [ - ]):
● [signup] A user can signup to the system
● [login] A user will be able to login to the system and the session will be created and used across for the other commands. Any existing session will be reinitiated with the new user logins.
● [post] A user can post a feed item.
● [follow] Users can follow other users.
● [reply] A user can comment on another user's feed item.
● [upvote/downvote] Upvote or downvote posts.
● [shownewsfeed] Any user can read his news feed. News items are sorted based on the following (following options to sort feed by are available):
Followed users: posts by followed users appear first.
Score (= upvotes - downvotes): higher the better.
The number of comments: higher the better.
Timestamp: more recent the better.
● Allow users to comment on a comment and upvote/downvote a comment.
● Display time in language like 2m ago, 1 hr ago etc.


Class Diagram:

  ![classDiag](https://user-images.githubusercontent.com/104002637/233931680-6f080738-330e-44f9-9c63-1563b4403d4f.png)
  
  Schema Diagram:
    ![schema](https://user-images.githubusercontent.com/104002637/233932263-393a7cc5-daed-40e5-bbda-87f0ce71f310.png)

