import { ChangeDetectionStrategy, Component, Input } from '@angular/core';

import SharedModule from 'app/shared/shared.module';
import { Databases } from 'app/admin/metrics/metrics.model';
import { filterNaN } from 'app/core/util/operators';

@Component({
  standalone: true,
  selector: 'm-2-gdil-metrics-datasource',
  templateUrl: './metrics-datasource.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [SharedModule],
})
export class MetricsDatasourceComponent {
  /**
   * object containing all datasource related metrics
   */
  @Input() datasourceMetrics?: Databases;

  /**
   * boolean field saying if the metrics are in the process of being updated
   */
  @Input() updating?: boolean;

  filterNaN = (input: number): number => filterNaN(input);
}
