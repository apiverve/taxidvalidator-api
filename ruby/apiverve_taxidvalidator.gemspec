# frozen_string_literal: true

Gem::Specification.new do |spec|
  spec.name          = "apiverve_taxidvalidator"
  spec.version       = "1.2.2"
  spec.authors       = ["APIVerve"]
  spec.email         = ["hello@apiverve.com"]

  spec.summary       = "Tax ID Validator API - Ruby Client"
  spec.description   = "Tax ID Validator checks US tax identification numbers including SSNs, EINs, and ITINs for structural validity. It accepts formatted or unformatted strings and returns validation results, normalized formatting, masked numbers, and the last four digits."
  spec.homepage      = "https://apiverve.com/marketplace/taxidvalidator?utm_source=ruby&utm_medium=referral&utm_content=homepage"
  spec.license       = "MIT"
  spec.required_ruby_version = ">= 2.7.0"

  spec.metadata["homepage_uri"] = spec.homepage
  spec.metadata["source_code_uri"] = "https://github.com/apiverve/taxidvalidator-API/tree/main/ruby"
  spec.metadata["changelog_uri"] = "https://apiverve.com/changelog"
  spec.metadata["documentation_uri"] = "https://docs.apiverve.com/ref/taxidvalidator"

  spec.files = Dir.glob("{lib}/**/*") + %w[README.md LICENSE]
  spec.require_paths = ["lib"]

  spec.add_dependency "faraday", ">= 1.0", "< 3.0"
  spec.add_dependency "faraday-multipart", "~> 1.0"
  spec.add_dependency "json", "~> 2.0"
end
