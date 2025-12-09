using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.TaxIDValidator
{
    /// <summary>
    /// Query options for the Tax ID Validator API
    /// </summary>
    public class TaxIDValidatorQueryOptions
    {
        /// <summary>
        /// The US Tax ID to validate (SSN, EIN, or ITIN format)
        /// Example: 123-45-6789
        /// </summary>
        [JsonProperty("taxid")]
        public string Taxid { get; set; }
    }
}
