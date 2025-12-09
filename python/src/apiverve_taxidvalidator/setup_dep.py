from setuptools import setup, find_packages

setup(
    name='apiverve_taxidvalidator',
    version='1.1.12',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Tax ID Validator is a comprehensive tool for validating US Tax IDs including Social Security Numbers (SSN), Employer Identification Numbers (EIN), and Individual Taxpayer Identification Numbers (ITIN).',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
