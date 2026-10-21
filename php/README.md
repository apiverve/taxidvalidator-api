# Tax ID Validator API - PHP Package

Tax ID Validator checks US tax identification numbers including SSNs, EINs, and ITINs for structural validity. It accepts formatted or unformatted strings and returns validation results, normalized formatting, masked numbers, and the last four digits.

## Installation

Install via Composer:

```bash
composer require apiverve/taxidvalidator
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Taxidvalidator\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute(['taxid' => '123-45-6789']);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Taxidvalidator\Client;
use APIVerve\Taxidvalidator\Exceptions\APIException;
use APIVerve\Taxidvalidator\Exceptions\ValidationException;

try {
    $response = $client->execute(['taxid' => '123-45-6789']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/taxidvalidator?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/taxidvalidator?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/taxidvalidator?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
