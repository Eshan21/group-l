# Contributing

## TOC
1. [Getting Started](getting-started)
2. [Branches](branches)
3. [Commits](commits)
4. [Documentation](documentation)
5. [Code Style](code-style)

## Getting Started

* Create new branch for the feature if it doesn't exist. Try to not work on `main` branch directly if possible.
* Create issue for the feature. Follow the issue template for corresponding issue.

## Branches

* Each topic should have its own branch. The `main` branch should rarely be worked on directly.
* Use `git merge` to combine branches.

## Commits

### Commit Organization

* Only commit code that is fully functional. Instead use `git stash` if you need to switch branches and `git stash apply` after.
* Seperate unrelated changes into separate commits. Use `git add -p <file>` to seperate changes in a single file into multiple commits.

### Commit Message Convention

* Capitalize first letter.
* Use present tense (e.g. 'fix' instead if 'fixes').
* Keep commit messages short. Add a description if there are more details that need to be explained.

### Commit Checklist

* Did I pull from the remote branch?
* Are there big changes in `main` that I need to merge into this branch?
* Does code run without errors?
* Does the code have comments and documentation? (See `Documentation` below)
* Is the code functional?
* Is the commit message easy to read?
* Does the commit only include related changes?

## Documentation

Javadoc will be used to generate documentation.
Doc comments have this format:

* First sentence is a summary
* Description in html
* Block tags (e.g. `@param`, `return`, `throws`, `see`)

```c
/**
 * Returns a number n multiplied by 2.
 * <p>The int n and return type are integers.</p>
 *
 * @param n the number will be multiplied by 2
 * @return n multiplied by 2
 */

public int x2(int n) {
    return n * 2;
}
```

See this [Guide](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html) for more information on formatting.

Run `gendocs` or `gendocs.cmd` to generate docs in the `doc` directory.

## Code Style

### Java

* Classes in UpperCamelCase
* Methods and local variables in lowerCamelCase
* Constants capitalized with underscores (e.g. `CONST_VAR`)
* Java classes imported in alphabetical order
* Spaces before and after operators (e.g. `+`, `-`) 
* Spaces after `,`
* Tabs are 4 spaces.

### HTML/CSS

* Ids and classes are lower case and seperated by hyphens (e.g. `class-name`).
* CSS declarations in alphabetical order
* Lists and tables have new line for each element:

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

