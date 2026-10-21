# Tax ID Validator API - Ruby Gem

Tax ID Validator checks US tax identification numbers including SSNs, EINs, and ITINs for structural validity. It accepts formatted or unformatted strings and returns validation results, normalized formatting, masked numbers, and the last four digits.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_taxidvalidator'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_taxidvalidator
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_taxidvalidator'

# Initialize the client
client = APIVerve::Taxidvalidator::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ taxid: "123-45-6789" })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ taxid: "123-45-6789" })
  puts response["data"]
rescue APIVerve::Taxidvalidator::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Taxidvalidator::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Taxidvalidator::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "valid": true,
    "taxid": "123-45-6789",
    "type": "SSN",
    "type_full": "Social Security Number",
    "format": "XXX-XX-XXXX",
    "normalized": "123-45-6789",
    "digits_only": "123456789",
    "masked": "***-**-6789",
    "last4": "6789",
    "is_placeholder": true,
    "validation_details": {
      "format_valid": true,
      "area_number_valid": true,
      "group_number_valid": true,
      "serial_number_valid": true
    },
    "risk_score": 35,
    "risk_level": "medium",
    "error": null
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/taxidvalidator?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/taxidvalidator?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/taxidvalidator?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
