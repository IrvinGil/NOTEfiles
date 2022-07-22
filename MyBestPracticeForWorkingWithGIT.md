Working with Git and Github version control in Software Development Projects
=====================================
## Best practice after opening IDE and starting to work on the project
* Always do **git pull** when working first with your project to update the changes from the remote repository to your local machine.
    ```
    git pull
    ``` 
* Check the branch you are in. Make sure that you have checkout out `your-branch` so that you will not have problems later on.
* 

## Best Practice for creating Git commit messages
* Use imperative mood instead of past tense means commit message should be "change..." instead of "changed".
* **AngularJs** suggested a practice of labelling your commit message based on what has been changed for easy understanding of the reader:
    * `feat` - a new feature is introduced with the changes
    * `fix` - a bug fixed has occured
    * `chore` - changes that do not relate to fix or feature and don't modify src or test files (for example during updating dependecies)
    * `refactor` - refactored code that neither fixes a bug nor adds a feature
    * `docs` - updates to documentation such as the README or other markdown files
    * `style` - changes that do not affect the meaning of the code, likely related to code formatting such as white spaces, missing semi-colons and so on.
    * `test` - including new or correcting previous tests
    * `perf` - performance improvements
    * `ci` - continous integration related
    * `build` - changes that affect the build system or external dependencies.






## Making a ***Pulll Request***
* Note that *pull requests* can only be made on Github. Git and Github are different software and Git does not have a command for pull request.
* Always check the branches that you want to point when creating a *pull request*. Some repositories have permission settings that do now allow you to close/delete your *pull request* if you have mistaken to point it on the wrong branch or repository.
* It is good to practice indicating your changes on the pull request message before clicking the button. Example:

    ### **Tasks done**
    <input type="checkbox" disabled checked />  Create test method for getters and setters of `Person.java`

    <input type="checkbox" disabled checked />  Create test method for `GetPersonContactNumber.java`

