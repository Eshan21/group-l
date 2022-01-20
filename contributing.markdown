---
layout: default
title: Contributing Guide
permalink: /contributor-guide
---

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

#### Building
- Read our [deployment guide](/deployment-guide) on instructions on how to build.

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

