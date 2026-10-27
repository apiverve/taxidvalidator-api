Pod::Spec.new do |s|
  s.name             = 'APIVerveTaxIDValidator'
  s.version          = '1.2.3'
  s.summary          = 'Tax ID Validator checks US tax identification numbers including SSNs, EINs, and ITINs for structural validity.'
  s.description      = <<-'DESC'
Tax ID Validator checks US tax identification numbers including SSNs, EINs, and ITINs for structural validity. It accepts formatted or unformatted strings and returns validation results, normalized formatting, masked numbers, and the last four digits.

This iOS/macOS SDK provides a convenient way to access the Tax ID Validator from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/taxidvalidator?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/taxidvalidator-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveTaxIDValidator/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
