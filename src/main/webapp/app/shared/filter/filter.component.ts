import { Component, Input } from '@angular/core';
import SharedModule from '../shared.module';
import { IFilterOptions } from './filter.model';

@Component({
  selector: 'm-2-gdil-filter',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './filter.component.html',
})
export default class FilterComponent {
  @Input() filters!: IFilterOptions;

  clearAllFilters(): void {
    this.filters.clear();
  }

  clearFilter(filterName: string, value: string): void {
    this.filters.removeFilter(filterName, value);
  }
}
