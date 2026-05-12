import subprocess
import re
import sys
import os

def strip_comments_and_whitespace(text):
    # Remove single line comments
    text = re.sub(r'//.*', '', text)
    # Remove multi-line comments
    text = re.sub(r'/\*.*?\*/', '', text, flags=re.DOTALL)
    # Remove whitespace
    text = re.sub(r'\s+', '', text)
    return text

def main():
    try:
        diff_output = subprocess.check_output(['git', 'diff', '--name-only'], text=True)
    except subprocess.CalledProcessError:
        print("Failed to run git diff")
        sys.exit(1)

    files = [f for f in diff_output.split('\n') if f.endswith('.java')]
    
    changed_logic_files = []

    for f in files:
        # Get original file content from git
        try:
            old_content = subprocess.check_output(['git', 'show', f'HEAD:{f}'], text=True)
        except subprocess.CalledProcessError:
            continue # New file? That's a logic change!
            
        with open(f, 'r') as file:
            new_content = file.read()
            
        old_stripped = strip_comments_and_whitespace(old_content)
        new_stripped = strip_comments_and_whitespace(new_content)
        
        if old_stripped != new_stripped:
            changed_logic_files.append(f)

    if changed_logic_files:
        print("Found logic changes in:")
        for f in changed_logic_files:
            print(f)
        sys.exit(1)
    else:
        print("Only comments (and README) changed.")
        sys.exit(0)

if __name__ == '__main__':
    main()
