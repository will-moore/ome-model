#!/usr/bin/env python


#
# Imports


import sys
from optparse import OptionParser
import os
import re


#
# Globals and constants

EXCLUDE_BASE = [
    'MixedContainer',
    '_MemberSpec',
    ]

PATTERN = "^class\s*(\w*)"
RE_PATTERN = re.compile(PATTERN)


#
# Functions for external use

def generate_coverage(outfile, infilename, options):
    exclude_classes = EXCLUDE_BASE
    exclude_classes.extend(options.exclude_additional.split())
    wrt = outfile.write
    mod_name = get_mod_name(infilename)
    wrt(HEADER % (mod_name, ))
    generate_coverage_1(wrt, infilename, mod_name, exclude_classes)
    wrt(FOOTER)
        

def generate_coverage_1(wrt, infilename, mod_name, exclude_classes):
    infile = open(infilename, 'r')
    for line in infile:
        mo = RE_PATTERN.search(line)
        if mo:
            name = mo.group(1)
            if (name not in exclude_classes and
                not name.startswith('Sax')):
                wrt("    '%s': %s.%s,\n" % (name, mod_name, name, ))
    infile.close()


def get_mod_name(infilename):
    s1 = os.path.split(infilename)[1]
    s2 = os.path.splitext(s1)[0]
    return s2


#
# Classes



#
# Functions for internal use and testing




#
# Templates

HEADER = '''\
#!/usr/bin/env python


#
# Imports

import sys
from optparse import OptionParser

import %s


#
# Globals and constants

CLASSES = {
'''

FOOTER = '''\
}

#
# Functions for external use



#
# Classes



#
# Functions for internal use and testing


def test(verbose):
    instances = []
    for name, class_ in CLASSES.iteritems():
        instance = class_()
        instances.append(instance)
    return instances


USAGE_TEXT = """
    python %prog [options] <somefile.xxx>
example:
    python %prog somefile.xxx"""

def usage(parser):
    parser.print_help()
    sys.exit(1)


def main():
    parser = OptionParser(USAGE_TEXT)
    parser.add_option("-v", "--verbose", action="store_true",
        dest="verbose", default=False,
        help="produce additional (verbose) output")
    (options, args) = parser.parse_args()
    if len(args) != 0:
        usage(parser)
    test(options.verbose)

        
if __name__ == "__main__":
    #import pdb; pdb.set_trace()
    main()

'''

# End Templates
#


USAGE_TEXT = """
    Generate a dictionary of class names and classes from a (superclass)
    module generated by generateDS.py.

    python %prog [options] <somefile.py>
Example:
    python %prog somefile.py"""

def usage(parser):
    parser.print_help()
    sys.exit(1)


def main():
    parser = OptionParser(USAGE_TEXT)
    parser.add_option("-x", "--exclude-additional", type="string",
        dest="exclude_additional", default='',
        help="additional class names to be excluded (blank separated).")
    parser.add_option("-f", "--force", action="store_true",
        dest="force", default=False,
        help="force over-write of outfile without asking.")
    (options, args) = parser.parse_args()
    outfilename = None
    if len(args) == 2:
        infilename = args[0]
        outfilename = args[1]
    elif len(args) == 1:
        infilename = args[0]
        outfilename = None
    else:
        usage(parser)
    if outfilename is None:
        outfile = sys.stdout
    else:
        if os.path.exists(outfilename):
            if options.force:
                outfile = open(outfilename, 'w')
            else:
                sys.stderr.write('Outfile (%s) exists.  '
                    'Use -f (or --force) to override.\n' %
                    (outfilename, ))
                sys.exit(1)
        else:
            outfile = open(outfilename, 'w')
    generate_coverage(outfile, infilename, options)
    if outfilename is not None:
        outfile.close()

        
if __name__ == "__main__":
    #import pdb; pdb.set_trace()
    main()

