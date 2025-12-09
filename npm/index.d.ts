declare module '@apiverve/taxidvalidator' {
  export interface taxidvalidatorOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface taxidvalidatorResponse {
    status: string;
    error: string | null;
    data: TaxIDValidatorData;
    code?: number;
  }


  interface TaxIDValidatorData {
      valid:             boolean;
      taxid:             string;
      type:              string;
      typeFull:          string;
      format:            string;
      normalized:        string;
      digitsOnly:        string;
      masked:            string;
      last4:             string;
      validationDetails: ValidationDetails;
      error:             null;
  }
  
  interface ValidationDetails {
      formatValid:       boolean;
      areaNumberValid:   boolean;
      groupNumberValid:  boolean;
      serialNumberValid: boolean;
  }

  export default class taxidvalidatorWrapper {
    constructor(options: taxidvalidatorOptions);

    execute(callback: (error: any, data: taxidvalidatorResponse | null) => void): Promise<taxidvalidatorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: taxidvalidatorResponse | null) => void): Promise<taxidvalidatorResponse>;
    execute(query?: Record<string, any>): Promise<taxidvalidatorResponse>;
  }
}
