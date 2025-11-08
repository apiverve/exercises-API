declare module '@apiverve/exercises' {
  export interface exercisesOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface exercisesResponse {
    status: string;
    error: string | null;
    data: any;
    code?: number;
  }

  export default class exercisesWrapper {
    constructor(options: exercisesOptions);

    execute(callback: (error: any, data: exercisesResponse | null) => void): Promise<exercisesResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: exercisesResponse | null) => void): Promise<exercisesResponse>;
    execute(query?: Record<string, any>): Promise<exercisesResponse>;
  }
}
