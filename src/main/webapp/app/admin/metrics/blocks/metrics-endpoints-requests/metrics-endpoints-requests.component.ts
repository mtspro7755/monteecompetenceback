import { Component, Input } from '@angular/core';

import SharedModule from 'app/shared/shared.module';
import { Services } from 'app/admin/metrics/metrics.model';

@Component({
  standalone: true,
  selector: 'm-2-gdil-metrics-endpoints-requests',
  templateUrl: './metrics-endpoints-requests.component.html',
  imports: [SharedModule],
})
export class MetricsEndpointsRequestsComponent {
  /**
   * object containing service related metrics
   */
  @Input() endpointsRequestsMetrics?: Services;

  /**
   * boolean field saying if the metrics are in the process of being updated
   */
  @Input() updating?: boolean;
}
