declare module '@apiverve/taxidvalidator' {
  export interface taxidvalidatorOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface taxidvalidatorResponse {
    status: string;
    error: string | null;
    data: TaxIDValidatorData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface TaxIDValidatorData {
      valid:             boolean | null;
      taxid:             null | string;
      type:              null | string;
      typeFull:          null | string;
      format:            null | string;
      normalized:        null | string;
      digitsOnly:        null | string;
      masked:            null | string;
      last4:             null | string;
      isPlaceholder:     boolean | null;
      validationDetails: ValidationDetails;
      riskScore:         number | null;
      riskLevel:         null | string;
      error:             null;
  }
  
  interface ValidationDetails {
      formatValid:       boolean | null;
      areaNumberValid:   boolean | null;
      groupNumberValid:  boolean | null;
      serialNumberValid: boolean | null;
  }

  export default class taxidvalidatorWrapper {
    constructor(options: taxidvalidatorOptions);

    execute(callback: (error: any, data: taxidvalidatorResponse | null) => void): Promise<taxidvalidatorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: taxidvalidatorResponse | null) => void): Promise<taxidvalidatorResponse>;
    execute(query?: Record<string, any>): Promise<taxidvalidatorResponse>;
  }
}
