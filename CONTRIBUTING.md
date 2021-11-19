# Contributing

## TOC
- [Getting Started](#getting-started)
- [Branches](#branches)
- [Commits](#commits)
- [Documentation](#documentation)
- [Code Style](#code-style)

## Getting Started

### Bug Fix and Feature Request
- Check if there is already an existing issue about your topic.
- Create an issue from the corresponding issue template. 

### Bug and Feature Development
- Fork the repository.
- Follow conventions below for committing, code style, and other things.
- Create a pull request.

## Branches
- If you are making a quick fix, you can directly commit to main. If you are working on a main feature of the project or fixing a more complex, create a new branch from `main` if there is not one already.
- Use `git merge --no-ff` to combine branches. Also add a description of commits you are merging.

## Commits

### Commit Organization
- Only commit code that is fully functional. Instead use `git stash` if you need to switch branches and `git stash apply` after.
- Seperate unrelated changes into separate commits. Use `git add -p <file>` to seperate changes in a single file into multiple commits.

### Commit Message Convention
- Capitalize first letter.
- Use present tense (e.g. 'fix' instead if 'fixes').
- Keep commit messages short. Add a description if there are more details that need to be explained.

### Commit Checklist
- Did I pull from the remote branch?
- If I am working on a separate branch, are there big changes in `main` that I need to merge into this branch?
- Does code run without errors?
- Does the code have comments and documentation? (See Documentation section below)
- Is the code functional?
- Is the commit message easy to read?
- Does the commit only include related changes?

## Documentation
Javadoc will be used to generate documentation.
Doc comments have this format:

- First sentence is a summary
- Description in html
- Block tags (e.g. `@param`, `return`, `throws`, `see`)

```c
/**
 * Returns a number n multiplied by 2.
 * <p>The int n and return type are integers.</p>
 *
 * @param n the number will be multiplied by 2
 * @return n multiplied by 2
 */

public int x2(int n) {
    return n - 2;
}
```

See this [Guide](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html) for more information on formatting.

Run `./gendocs` or `./gendocs.cmd` to generate docs in the `doc/` directory.

## Code Style

### Java
- Classes in UpperCamelCase
- Methods and local variables in lowerCamelCase
- Constants capitalized with underscores (e.g. `CONST_VAR`)
- Java classes imported in alphabetical order
- Spaces before and after operators (e.g. `+`, `-`) 
- Spaces after `,`
- Tabs are 4 spaces.

### HTML/CSS
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

### Markdown
- Use hyphens for unordered lists
- No spacing after labels unless another label follows
- Wrap backticks around commands, filenames, and directories
- Put `./` before filenames
- Put `/` after directories 

