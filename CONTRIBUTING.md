# Contributor Guide

## References
- [Getting Started](#getting-started)
- [Checklists](#checklists)
    - [Branch Checklist](#branch-checklist)
    - [Commit Checklist](#commit-checklist)
    - [Merge Checklist](#merge-checklist)
- [Branches](#branches)
- [Commits](#commits)
- [Documentation](#documentation)
- [Code Style](#code-style)
    - [Java](#java)
    - [HTML/CSS](#htmlcss)
    - [Markdown](#markdown)

## Getting Started

#### Bug Fix and Feature Request
- Make sure your source is up to date.
- Check if there is already an existing issue about your topic.
- Create an issue from the corresponding issue template. 

#### Bug and Feature Development
- Fork the repository.
- Follow conventions below for committing, code style, and other things.
- Create a pull request.

## Checklists
These check lists are guidelines for consistency and avoiding conflicts.

#### Branch Checklist
- Is there a branch that includes this feature?
- Does the feature require multiple commits?
- Does the branch contain only one specific feature? (If there could be messy history/conflict as a result, consider making multiple branches)

#### Commit Checklist
- Did I pull from the remote branch?
- If I am working on a separate branch, are there big changes in `main` that I need to merge into this branch?
- Could merge conflicts occur with other branches? (Consider merging to `main` with only those conflict files)
- Does code run without errors?
- Does the code have comments and documentation? (See Documentation section below)
- Is the code functional?
- Does the commit only include related changes?

#### Merge Checklist
- Is the feature/bug-fix complete? (Committing without complete feature may make history messy)
- Are both local branches up to date with remote?
- Is this a complete feature that needs review? (Make a pull request)
- Is this merge reslove an issue and/or branch? (Close the issue/Delete the branch)

## Branches

#### Branch Workflow
- If you are making a quick fix, you can directly commit to `main`. If you are working on a main feature of the project or fixing a complex bug, create a new branch from `main` if there is not one already.
- Merging into `main` should generally only be done if a feature is complete, in which case a pull request should be made and reviewed by another person.
- Use `git merge --squash` followed by `git commit` to combine branches. All commits in the squash commit should be related.
- Squash commits --NEED-- to have a title that is easy to understand without context, as they are in `main` with other unrelated commits. Add a description for more details.

#### Branch Design
- List of permanent branches:
    - `main`   - The development branch
    - `stable` - The release branch

- Other branches will be temporary feature or bug-fixing branches that should be deleted after use.
- Branches should be specific and only cover one feature.

## Commits

#### Commit Organization
- Only commit code that is fully functional. Instead use `git stash` if you need to switch branches and `git stash apply` after.
- Seperate unrelated changes into separate commits. Use `git add -p <file>` to seperate changes in a single file into multiple commits.

#### Commit Message Convention
- Capitalize first letter.
- Use present tense (e.g. 'fix' instead if 'fixes').
- Keep commit messages short. Add a description if there are more details that need to be explained.
- Don't use backticks for surrounding code/git strings in commit messages. Wrap `'` around them instead.
- Use `"` for other quoted strings.

## Documentation
Javadoc will be used to generate documentation.
Doc comments have this format:

- First sentence is a summary
- Description in html
- Block tags (e.g. `@param`, `return`, `throws`, `see`)
- @param

```c
/--
 - Returns a number n squared.
 - <p>Does not check for wrapping.</p>
 -
 - @param  n  the number squared
 - @return    the number n multiplied by 2
 -/

public int square(int n) {
    return n * n;
}
```

See this [guide](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html) for more information on formatting.

Run `./gendocs` or `./gendocs.cmd` to generate docs in the `doc/` directory.

## Code Style

#### Java
- Classes in UpperCamelCase
- Methods and local variables in lowerCamelCase
- Constants capitalized with underscores (e.g. `CONST_VAR`)
- Java classes imported in alphabetical order
- Spaces before and after operators (e.g. `+`, `-`) 
- Spaces after `,`
- Tabs are 4 spaces.

#### HTML/CSS
- Ids and classes are lower case and seperated by hyphens (e.g. `class-name`).
- CSS declarations in alphabetical order
- Lists and tables have new line for each element:

```c
<ul>
    <li>Apple</li>
    <li>Orange</li>
    <li>Banana</li>
</ul>
```

```c
<table>
    <thead>
        <tr>
            <th>Fruit</th>
            <th>Cost</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Apple</td>
            <td>$1.00</td>
        </tr>
    </tbody>
</table>
```

#### Markdown
- Use hyphen to for unordered list
- No spacing after labels unless another label follows
- Wrap backticks around code/git strings (e.g. file/dirs, commands, branches)
- Put `./` before filenames
- Put `/` after directories 

